package editlist.exceptionHandler_18.phonebookV6;

public class MenuChoiceException extends Exception{
  int wrongChoice;

  public MenuChoiceException(int choice) {
    super("잘못된 선택이 이뤄졌습니댜. ");
    this.wrongChoice = choice;
  }

  public void showWrongChoice(){
    System.out.println(wrongChoice+"에 해당하는 선택은 존재하지 않습니다.");
  }
}
