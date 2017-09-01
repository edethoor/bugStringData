package com.example.demo;

import com.example.demo.dao.EnvoiEntryRepository;
import com.example.demo.pojo.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class) @DataMongoTest public class DemoApplicationTests {

	@Autowired private EnvoiEntryRepository envoiEntryRepository;

	@Test public void classicSave() {

		EnvoiEntry savedEnvoiEntry = envoiEntryRepository.save(getEnvoiEntryMock());
		savedEnvoiEntry.getRecipients().get(0).getEnvoi().getNotifications().get(0).getAttachments().add(getFileLinkToAdd());
		savedEnvoiEntry = envoiEntryRepository.save(savedEnvoiEntry);

		EnvoiEntry retrievedEnvoiEntry = envoiEntryRepository.findOne(savedEnvoiEntry.getId());
		Assert.assertNotNull(retrievedEnvoiEntry);
		List<AbstractAttachment> retrivedAttachments = retrievedEnvoiEntry.getRecipients().get(0).getEnvoi()
				.getNotifications().get(0).getAttachments();
		Assert.assertNotNull(retrivedAttachments);
		Assert.assertEquals(3, retrivedAttachments.size());

	}

	@Test public void customSave() {
		EnvoiEntry savedEnvoiEntry = envoiEntryRepository.save(getEnvoiEntryMock());
		String id = savedEnvoiEntry.getId();
		savedEnvoiEntry.setId("");

		savedEnvoiEntry.getRecipients().get(0).getEnvoi().getNotifications().get(0).getAttachments().add(getFileLinkToAdd());
		int nbUpdated = envoiEntryRepository.customUpdate(id, savedEnvoiEntry);
		Assert.assertEquals(1, nbUpdated);

		EnvoiEntry retrievedEnvoiEntry = envoiEntryRepository.findOne(id);
		Assert.assertNotNull(retrievedEnvoiEntry);
		List<AbstractAttachment> attachments = retrievedEnvoiEntry.getRecipients().get(0).getEnvoi().getNotifications().get(0).getAttachments();
		Assert.assertEquals(3, attachments.size());
	}

	private FileLink getFileLinkToAdd(){
		FileLink addedFileLink = new FileLink();
		addedFileLink.setObjectLink(AttachmentObjectLink.FILE);
		addedFileLink.setName("myNewFileName");
		return  addedFileLink;
	}

	private EnvoiEntry getEnvoiEntryMock() {
		EnvoiEntry envoiEntry = new EnvoiEntry();
		List<Recipient> recipients = new ArrayList<>();
		Envoi envoi = new Envoi();
		List<Notification> notifications = new ArrayList<>();
		Notification notif = new Notification();
		List<AbstractAttachment> attachments = new ArrayList<>();
		FileLink fileLink = new FileLink();
		fileLink.setObjectLink(AttachmentObjectLink.FILE);
		fileLink.setName("myFile");
		attachments.add(fileLink);

		PjvLink pjvLink = new PjvLink();
		pjvLink.setObjectLink(AttachmentObjectLink.PJV);
		pjvLink.setNomFichier("myPjvFileName");
		attachments.add(pjvLink);

		notif.setAttachments(attachments);
		notif.setNbAttempts(0);
		notifications.add(notif);

		envoi.setNotifications(notifications);
		envoi.setIsSelected(true);

		Recipient recipient = new Recipient();
		recipient.setEnvoi(envoi);
		recipients.add(recipient);

		envoiEntry.setRecipients(recipients);
		return envoiEntry;
	}

}
