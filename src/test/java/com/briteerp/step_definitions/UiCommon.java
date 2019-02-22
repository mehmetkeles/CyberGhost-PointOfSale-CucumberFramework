package com.briteerp.step_definitions;

import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Pages;

public abstract class UiCommon {
    Pages pages = new Pages();
    protected final int timeOutInSec = Integer.parseInt(ConfigurationReader.getProperty("timeOutInSec"));

}
