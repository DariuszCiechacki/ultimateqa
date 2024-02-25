package library.modules.automation.applifecycle.forms.sprint2;

import library.modules.automation.applifecycle.AppLifecycleData;

public class Sprint2Form implements Sprint2Interface{
    private final AppLifecycleData appLifecycleData;

    public Sprint2Form() {
        this.appLifecycleData = new AppLifecycleData();
    }

    @Override
    public Sprint2Form enterFirstName(String firstName) {
        appLifecycleData.enterFirstName(firstName);

        return this;
    }

    @Override
    public Sprint2Form enterLastName(String lastName) {
        appLifecycleData.enterLastName(lastName);

        return this;
    }
}
