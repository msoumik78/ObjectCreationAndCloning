package objectCreation;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements Serializable {

	private static final long serialVersionUID = -8942318977797946582L;
	private String streetDetails;
	private int iHouseNumber;
	private String postCode;

}
