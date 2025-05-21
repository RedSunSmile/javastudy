package editlist.exceptionHandler_18.phonebookV6;

public class PhoneUnivInfo extends PhoneInfo {

  String major;
  int year;

  public PhoneUnivInfo(String name, String num, String major, int year){
    super(name,num);
    this.major=major;
    this.year=year;
  }


  public void showPhoneInfo(){
    super.showPhoneInfo();

    System.out.println("major : "+major);
    System.out.println("year : "+year);
  }
}
