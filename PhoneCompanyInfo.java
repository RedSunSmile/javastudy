package editlist.overriding2_16chapter.refactoring;

public class PhoneCompanyInfo extends PhoneInfo{

  String company;

  public PhoneCompanyInfo(String name, String num, String company) {
    super(name, num);
    this.company = company;
  }

  public void showPhoneInfo(){
    super.showPhoneInfo();
    System.out.println("company : "+company);
  }
}
