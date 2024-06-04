package com.megadev.afterrome.object.user;

import com.megadev.afterrome.object.profession.XProfession;
import lombok.Getter;

@Getter
public class XUser {
    private final String uuid;
    private final XProfession profession;
    private final int healths;
    private final int points;

    public XUser(String uuid, XProfession profession, int healths, int points) {
        this.uuid = uuid;
        this.profession = profession;
        this.healths = healths;
        this.points = points;
    }
}
