package dev.mega.afterromeimpl;

import dev.mega.afterrome.AfterRome;

public class AfterRomeImpl extends AfterRome {
    public AfterRomeImpl() {
        super("dev.mega.afterromeimpl.manager", "dev.mega.afterromeimpl.listener");
    }

    @Override
    protected void enableImpl() {
    }

    @Override
    protected void disableImpl() {
    }
}
