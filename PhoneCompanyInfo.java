package editlist.collectionframework_22chapter.collectionRefactoringV7;

public class PhoneCompanyInfo extends PhoneInfo {

  String company;

  public PhoneCompanyInfo(String name, String num, String company) {
    super(name, num);
    this.company = company;
  }

  public void showPhoneInfo(){
    super.showPhoneInfo();
    System.out.println("company : "+company);
  }

  public int hashCode(){
    return name.hashCode();
  }

  public boolean equals(Object obj){
    PhoneCompanyInfo cmp=(PhoneCompanyInfo)obj;
    if(name.compareTo(cmp.name)==0){
      return true;
    }else{
      return false;
    }
  }
}
