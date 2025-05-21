package editlist.fileIOstream_24chapter.streamRefactoringV8;

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

  public int hashCode(){
    return name.hashCode();
  }

  public boolean equals(Object obj){
    PhoneUnivInfo cmp=(PhoneUnivInfo)obj;
    if(name.compareTo(cmp.name)==0){
      return true;
    }else{
      return false;
    }
  }
}
