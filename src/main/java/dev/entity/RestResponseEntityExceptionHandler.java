package dev.entity;

import dev.exception.CollegueInvalidException;
import dev.exception.CollegueNontrouveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice désigne un greffon appliqué aux controlleurs
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

// la méthode handleConflict est exécutée lorsqu'un contrôleur émet une exception présente
// dans la liste définie par l'annotation @ExceptionHandler
@ExceptionHandler(value = { CollegueNontrouveException.class})
protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}
   
   
   @ExceptionHandler(value = CollegueInvalidException.class
)
   protected ResponseEntity<Object> handleInvalidCollegue(RuntimeException ex, WebRequest request) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
}
}