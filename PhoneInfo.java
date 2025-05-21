package editlist.fileIOstream_24chapter.streamRefactoringV8;

public class PhoneInfo {
  String name;
  String phoneNumber;

  public PhoneInfo(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void showPhoneInfo(){
    System.out.println("name : "+name);
    System.out.println("phone : "+phoneNumber);
  }

  public int hashCode(){
    return name.hashCode();
  }

  public boolean equals(Object obj){
    PhoneInfo cmp=(PhoneInfo)obj;
    if(name.compareTo(cmp.name)==0){
      return true;
    }else{
      return false;
    }
  }
}
