package it.acsoftware.hyperiot.widget.model;


import it.acsoftware.hyperiot.base.model.HyperIoTAbstractEntity;
import it.acsoftware.hyperiot.base.validation.NotNullOnPersist;
import it.acsoftware.hyperiot.huser.model.HUser;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "widget_id"}))
public class WidgetRating extends HyperIoTAbstractEntity {

    private HUser user;
    private Widget widget;
    private int rating;

    @NotNullOnPersist
    @ManyToOne(targetEntity = HUser.class)
    public HUser getUser() {
        return user;
    }

    public void setUser(HUser user) {
        this.user = user;
    }

    /**
     * @return the related widget
     */
    @NotNullOnPersist
    @ManyToOne(targetEntity = Widget.class)
    public Widget getWidget() {
        return widget;
    }

    /**
     * @param widget the related widget
     */
    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
