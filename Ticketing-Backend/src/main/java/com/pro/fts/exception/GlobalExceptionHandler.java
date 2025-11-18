package com.pro.fts.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateUserIdException.class)
	public ResponseEntity<ApiResponse> DuplicateUserIdExceptionHandler(DuplicateUserIdException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.CONFLICT);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ApiResponse> InvalidUserExceptionHandler(InvalidUserException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ApiResponse> internalServerErrorExceptionHandler(InternalServerErrorException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchExceptionHandler(
			MethodArgumentTypeMismatchException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ApiResponse> NullPointerExceptionHandler(NullPointerException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL-SERVER-ERROR");
	}

	@ExceptionHandler(value = TicketIdNotFoundException.class)
	public ResponseEntity<ApiResponse> TicketIdDoesNotExistExceptionHandler(TicketIdNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TypeNotFoundException.class)
	public ResponseEntity<ApiResponse> TypeDoesNotExistExceptionHandler(TypeNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = StatusNotFoundException.class)
	public ResponseEntity<ApiResponse> StatusDoesNotExistExceptionHandler(StatusNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidDateRangeException.class)
	public ResponseEntity<ApiResponse> InvalidDateRangeExceptionHandler(InvalidDateRangeException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}

}
