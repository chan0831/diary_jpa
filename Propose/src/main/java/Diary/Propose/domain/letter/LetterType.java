package Diary.Propose.domain.letter;

public enum LetterType {
    //letterType radio button 추가.

    DIARY("일기"), CALL("통화 기록"), ETC("기타");

    private final String description;

    LetterType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
