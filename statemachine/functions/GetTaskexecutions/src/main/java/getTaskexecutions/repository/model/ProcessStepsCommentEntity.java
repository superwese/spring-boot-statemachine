package getTaskexecutions.repository.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

// THIS CLASS IS GENERATED DO NOT CHANGE

/**
 * The persistent class for the samples_comments database table.
 *
 */
@Entity
@Table(name = "process_steps_comments")

public class ProcessStepsCommentEntity extends
        JpaEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "uuid", nullable = false, insertable = true, updatable = false)
    private UUID uuid;

	@Column(name = "comment_text", nullable = true, insertable = true, updatable = true)
	private String commentText;

	@ManyToOne
	@JoinColumn(name = "process_step_uuid")
	private ProcessStepEntity processStepEntity;

	@Column(name = "email", nullable = true, insertable = true, updatable = true)
	private String email;

	@Column(name = "sequence_nr", updatable = false)
	private Integer sequenceNr;

	public ProcessStepsCommentEntity() {
	}

	public ProcessStepsCommentEntity(String commentText, ProcessStepEntity processStepEntity, String email, Integer sequenceNr) {
		this.commentText = commentText;
		this.processStepEntity = processStepEntity;
		this.email = email;
		this.sequenceNr = sequenceNr;
	}

	public UUID getUuid() {
        return this.uuid;
    }

	public UUID getProcessStepUuid() {
		return this.processStepEntity.getUuid();
	}

	public String getCommentText() {
		return this.commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public ProcessStepEntity getProcessStepEntity() {
		return this.processStepEntity;
	}

	public void setProcessStepEntity(ProcessStepEntity processStepEntity) {
		this.processStepEntity = processStepEntity;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public Integer getSequenceNr() {
		return sequenceNr;
	}

	public void setSequenceNr(Integer sequenceNr) {
		this.sequenceNr = sequenceNr;
	}
}
