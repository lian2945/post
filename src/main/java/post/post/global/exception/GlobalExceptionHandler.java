package post.post.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ErrorResponse illegalArgumentException(){
//        return ErrorResponse.builder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
//                .message("이건 내가 만든 Illegal")
//                .build();
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(
                        e.getBindingResult().getFieldError() != null
                        ? e.getBindingResult().getFieldError().getDefaultMessage()
                        : "Validation error occurred"
                )
                .build();
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ErrorResponse runtimeException(){
//        return ErrorResponse.builder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
//                .message("RunTime Exception")
//                .build();
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ErrorResponse handleException() {
//        return ErrorResponse.builder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
//                .message("내가 만든 예외처리기")
//                .build();
//    }
}
