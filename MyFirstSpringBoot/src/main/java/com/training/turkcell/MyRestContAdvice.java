package com.training.turkcell;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyRestContAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleEx2(final Exception exceptionParam) {
        ErrorObj errorObjLoc = null;
        if (exceptionParam instanceof MyException) {
            MyException myException = (MyException) exceptionParam;
            errorObjLoc = new ErrorObj(myException.getMsg(),
                                       1000,
                                       "IT",
                                       "Billing",
                                       "Charging");
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                 .body(errorObjLoc);
        } else if (exceptionParam instanceof IllegalArgumentException) {
            errorObjLoc = new ErrorObj(exceptionParam.getMessage(),
                                       1001,
                                       "IT",
                                       "Billing",
                                       "Charging");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(errorObjLoc);

        } else if (exceptionParam instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException me = (MethodArgumentNotValidException) exceptionParam;
            BindingResult bindingResultLoc = me.getBindingResult();
            errorObjLoc = new ErrorObj("Validation Error ",
                                       1000,
                                       "IT",
                                       "Billing",
                                       "Charging");
            List<ObjectError> allErrorsLoc = bindingResultLoc.getAllErrors();
            for (ObjectError objectErrorLoc : allErrorsLoc) {
                ErrorObj e = new ErrorObj(objectErrorLoc.getCode()
                                          + " "
                                          + objectErrorLoc.getDefaultMessage()
                                          + " "
                                          + objectErrorLoc.getObjectName()
                                          + " "
                                          + objectErrorLoc.getArguments()
                                          + " "
                                          + objectErrorLoc.getCodes(),
                                          2000,
                                          "IT",
                                          "Billing",
                                          "Charging");
                errorObjLoc.add(e);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(errorObjLoc);
        } else {
            errorObjLoc = new ErrorObj(exceptionParam.getMessage(),
                                       1002,
                                       "IT",
                                       "Billing",
                                       "Charging");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(errorObjLoc);

        }
    }

    // Tek response status dönmek için
    //    @ExceptionHandler(Exception.class)
    //    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //    public ErrorObj handleEx(final Exception exceptionParam) {
    //        ErrorObj errorObjLoc = null;
    //        if (exceptionParam instanceof MyException) {
    //            MyException myException = (MyException) exceptionParam;
    //            errorObjLoc = new ErrorObj(myException.getMsg(),
    //                                       1000,
    //                                       "IT",
    //                                       "Billing",
    //                                       "Charging");
    //
    //        } else if (exceptionParam instanceof IllegalArgumentException) {
    //            errorObjLoc = new ErrorObj(exceptionParam.getMessage(),
    //                                       1001,
    //                                       "IT",
    //                                       "Billing",
    //                                       "Charging");
    //        } else {
    //            errorObjLoc = new ErrorObj(exceptionParam.getMessage(),
    //                                       1002,
    //                                       "IT",
    //                                       "Billing",
    //                                       "Charging");
    //
    //        }
    //
    //        return errorObjLoc;
    //    }


    // Method bazlı exception handling
    //    @ExceptionHandler(IllegalArgumentException.class)
    //    public ErrorObj handleEx(final IllegalArgumentException exceptionParam) {
    //        ErrorObj errorObjLoc = new ErrorObj(exceptionParam.getMessage(),
    //                                            1000,
    //                                            "IT",
    //                                            "Billing",
    //                                            "Charging");
    //        return errorObjLoc;
    //    }
    //
    //    @ExceptionHandler(MyException.class)
    //    public ErrorObj handleEx(final MyException exceptionParam) {
    //        ErrorObj errorObjLoc = new ErrorObj(exceptionParam.getMsg(),
    //                                            1000,
    //                                            "IT",
    //                                            "Billing",
    //                                            "Charging");
    //        return errorObjLoc;
    //    }

}
