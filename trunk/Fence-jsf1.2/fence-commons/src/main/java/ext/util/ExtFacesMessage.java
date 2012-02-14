package ext.util;

import javax.faces.application.FacesMessage;

/**
 * @author abner 
 * @used used for validate and CONVERSION exception message.
 */
public class ExtFacesMessage extends FacesMessage {
	private static final long serialVersionUID = -5550847821294736182L;
	private String compId;

	public ExtFacesMessage() {
		super();
	}

	public ExtFacesMessage(String compId) {
		super();
		this.compId = compId;
	}

	public ExtFacesMessage(FacesMessage facesMessage, String compId) {
		this.setDetail(facesMessage.getDetail());
		this.setSeverity(facesMessage.getSeverity());
		this.setSummary(facesMessage.getSummary());
		this.compId = compId;
	}

	public ExtFacesMessage(Severity severity, String compId, String summary,
			String detail) {
		super(severity, summary, detail);
		this.compId = compId;
	}

	public ExtFacesMessage(String compId, String summary, String detail) {
		super(summary, detail);
		this.compId = compId;
	}

	public ExtFacesMessage(String compId, String summary) {
		super(summary);
		this.compId = compId;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}
}
