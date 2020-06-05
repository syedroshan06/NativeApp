Feature: View account details



  Scenario: User navigates to account dashboard
    Given User waits for the accounts module to be available
    When User view his Account Information
    Then System presents following account information: Username,Account name,Member ID,Last login



    Scenario: User navigate to Profile settings and access profile settings option
      Given User is on Account dashboard
      When User access profile settings option
      Then System displays profile settings menu which includes: Member details,Contact details,Communication settings