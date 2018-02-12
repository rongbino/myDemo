package trong.mr;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.time.LocalDateTime;

public class A {
  private String aa;

  @JsonIgnore
  private String bb;

  private String cc;

  private LocalDateTime time = LocalDateTime.now();

  public String getAa() {
    return aa;
  }

  public void setAa(String aa) {
    this.aa = aa;
  }

  public String getBb() {
    return bb;
  }

  public void setBb(String bb) {
    this.bb = bb;
  }

  public String getCc() {
    return cc;
  }

  public void setCc(String cc) {
    this.cc = cc;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }
}
