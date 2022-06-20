package hu.nye.algrelatives.exception;

public class RelativeAlreadyExistsException extends RuntimeException{

  private String message;

  public RelativeAlreadyExistsException() {}

  public RelativeAlreadyExistsException(String msg)
  {
    super(msg);
    this.message = msg;
  }

}
