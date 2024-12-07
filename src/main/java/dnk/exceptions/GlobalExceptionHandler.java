package dnk.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dnk.constants.AppConstants;
import dnk.dtos.commons.BaseResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<BaseResponse<String>> handleGeneralException(Exception ex) {
                return ResponseEntity.internalServerError()
                                .body(BaseResponse.error(AppConstants.STATUS_500, ex.getMessage()));
        }
}
