package editlist.overriding2_16chapter.refactoring;

public class PhoneBookVer04 {
  public static void main(String[] args) throws NullPointerException {
    PhoneBookManager manager=new PhoneBookManager();


    while(true) {
      MenuViewer.showMenu();
      int choice = MenuViewer.keyboard.nextInt();
      //버퍼비우기
      MenuViewer.keyboard.nextLine();

      if (choice == 1) {
        manager.inputData();

      } else if (choice == 2) {
        manager.searchData();

      }else if(choice==3) {
        manager.deleteData();

      }else if(choice==4){
        System.out.println("프로그램을 종료합니다.");
        return;
      } else{
        System.out.println("잘못된 선택입니다.");
      }
    }
  }

}
