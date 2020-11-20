package getTaskexecutions.repository.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class ProcessCtrlCategoryEmbeddable {

	@Column(name = "process_ctrl_category_reference_uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "process_ctrl_category_title", nullable = true, insertable = true, updatable = false)
	private String title;

	@Column(name = "process_ctrl_category_title_key", nullable = true, insertable = true, updatable = false)
	private String titleKey;

	public ProcessCtrlCategoryEmbeddable() {
	}

	public ProcessCtrlCategoryEmbeddable(UUID uuid,
			String title,
			String titleKey) {
		this.uuid = uuid;
		this.title = title;
		this.titleKey = titleKey;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ProcessCtrlCategoryEmbeddable that = (ProcessCtrlCategoryEmbeddable) o;

		return uuid != null ? uuid.equals(that.uuid) : that.uuid == null;

	}

	@Override
	public int hashCode() {
		return uuid != null ? uuid.hashCode() : 0;
	}
}
