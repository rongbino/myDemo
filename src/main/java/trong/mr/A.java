package trong.mr;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

public class A {
  private String aa;

  @JsonIgnore
  private String bb;

  private String cc;

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
}
