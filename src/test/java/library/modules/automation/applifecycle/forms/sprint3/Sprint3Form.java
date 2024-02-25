package library.modules.automation.applifecycle.forms.sprint3;

import library.modules.automation.applifecycle.AppLifecycleData;

public class Sprint3Form implements Sprint3Interface {
    private final AppLifecycleData appLifecycleData;

    public Sprint3Form() {
        this.appLifecycleData = new AppLifecycleData();
    }

    @Override
    public Sprint3Form setRadiobutton(String value) {
        appLifecycleData.setRadiobutton(value);

        return this;
    }

    @Override
    public Sprint3Form enterFirstName(String firstName) {
        appLifecycleData.enterFirstName(firstName);

        return this;
    }

    @Override
    public Sprint3Form enterLastName(String lastName) {
        appLifecycleData.enterLastName(lastName);

        return this;
    }
}
