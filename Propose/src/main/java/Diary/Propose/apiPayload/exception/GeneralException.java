package Diary.Propose.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import Diary.Propose.apiPayload.code.BaseErrorCode;
import Diary.Propose.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){

        return this.code.getReasonHttpStatus();
    }
}