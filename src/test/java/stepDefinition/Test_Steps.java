package stepDefinition;

/**
 * @author Syed Caazimuddin
 */


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Keyword.Module.*;



public class Test_Steps {




    @Given("^User waits for the accounts module to be available$")
    public void user_waitsfor_the_accounts_module_to_be_available() throws Throwable {

        AvailabilityOfAccountDashboard();



    }

    @Given("^User is on Account dashboard$")
    public void user_is_on_account_dashboard_and_navigated_to_profile_settings() throws Throwable {

        AccountDashboard();


    }

    @When("^User view his Account Information$")
    public void user_view_his_account_information() throws Throwable {

        ClickAccountDeeplink();

    }

    @When("^User access profile settings option$")
    public void user_access_profile_settings_option() throws Throwable {


        ClickProfileSettings();

    }

    @Then("^System presents following account information: Username,Account name,Member ID,Last login$")
    public void system_presents_following_account_information_usernameaccount_namemember_idlast_login() throws Throwable {


        Assert_Account_Information();

    }

    @Then("^System displays profile settings menu which includes: Member details,Contact details,Communication settings$")
    public void system_displays_profile_settings_menu_which_includes_member_detailscontact_detailscommunication_settings() throws Throwable {

        Assert_Profile_Settings_Menu();

    }

}
