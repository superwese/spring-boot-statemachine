package getTaskexecutions.repository.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

/**
 * Created by oliver on 18.08.2016.
 */
@Embeddable
public class QualityManualEmbeddable {

	@Column(name = "quality_manual_uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "quality_manual_title", nullable = true, insertable = true, updatable = false)
	private String title;

	public QualityManualEmbeddable(){}

	public QualityManualEmbeddable(UUID uuid, String title) {
		this.uuid = uuid;
		this.title = title;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		QualityManualEmbeddable that = (QualityManualEmbeddable) o;

		return uuid != null ? uuid.equals(that.uuid) : that.uuid == null;

	}

	@Override
	public int hashCode() {
		return uuid != null ? uuid.hashCode() : 0;
	}
}
