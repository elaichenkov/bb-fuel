package com.backbase.testing.dataloader;

import com.backbase.testing.dataloader.setup.BankSetup;
import com.backbase.testing.dataloader.setup.ServiceAgreementsSetup;
import com.backbase.testing.dataloader.setup.UsersSetup;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        BankSetup bankSetup = new BankSetup();
        UsersSetup usersSetup = new UsersSetup();
        ServiceAgreementsSetup serviceAgreementsSetup = new ServiceAgreementsSetup();

        bankSetup.setupBankWithEntitlementsAdminAndProducts();
        bankSetup.setupBankNotifications();
        usersSetup.setupUsersWithAndWithoutFunctionDataGroupsPrivileges();
        serviceAgreementsSetup.setupCustomServiceAgreements();
    }
}
