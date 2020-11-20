package getTaskexecutions.repository.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

/**
 * Created by micha on 23.08.16.
 */

@Embeddable
public class ProcessControlEmbeddable {

	@Column(name = "process_ctrl_uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "process_ctrl_title", nullable = true, insertable = true, updatable = false)
	private String title;

	public ProcessControlEmbeddable(){}

	public ProcessControlEmbeddable(UUID uuid, String title) {
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

		ProcessControlEmbeddable that = (ProcessControlEmbeddable) o;

		return uuid != null ? uuid.equals(that.uuid) : that.uuid == null;

	}

	@Override
	public int hashCode() {
		return uuid != null ? uuid.hashCode() : 0;
	}
}
