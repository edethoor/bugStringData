package com.example.demo.pojo;

import java.util.Date;
import java.util.List;

public class Envoi {
	/**
	 * La liste des notifications choisie pour l’envoi et les pièces jointes
	 * associés. Dans le cas d’un document HP il peut y avoir plusieurs fois le
	 * même canal (cas de la réception multiple).
	 */
	private List<Notification> notifications;

	private boolean isSelected;

	private Float nbCreditsBase;

	private Date limitResponseDate;

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public Float getNbCreditsBase() {
		return nbCreditsBase;
	}

	public void setNbCreditsBase(Float nbCreditsBase) {
		this.nbCreditsBase = nbCreditsBase;
	}

	public Date getLimitResponseDate() {
		return limitResponseDate;
	}

	public void setLimitResponseDate(Date limitResponseDate) {
		this.limitResponseDate = limitResponseDate;
	}

	public Envoi() {
		super();
	}

	public Envoi(List<Notification> canaux, boolean isSelected, Float nbCreditsBase) {
		super();
		this.notifications = canaux;
		this.isSelected = isSelected;
		this.nbCreditsBase = nbCreditsBase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notifications == null) ? 0 : notifications.hashCode());
		result = prime * result + (isSelected ? 1231 : 1237);
		result = prime * result + ((nbCreditsBase == null) ? 0 : nbCreditsBase.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Envoi other = (Envoi) obj;
		if (notifications == null) {
			if (other.notifications != null) {
				return false;
			}
		} else if (!notifications.equals(other.notifications)) {
			return false;
		}
		if (isSelected != other.isSelected) {
			return false;
		}
		if (nbCreditsBase == null) {
			if (other.nbCreditsBase != null) {
				return false;
			}
		} else if (!nbCreditsBase.equals(other.nbCreditsBase)) {
			return false;
		}
		return true;
	}

}
