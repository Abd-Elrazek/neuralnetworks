package com.github.neuralnetworks.training.events;

import com.github.neuralnetworks.events.TrainingEvent;
import com.github.neuralnetworks.training.Trainer;

public class TrainingFinishedEvent extends TrainingEvent {

    private static final long serialVersionUID = -5239379347414855784L;

    public TrainingFinishedEvent(Trainer<?> source) {
	super(source);
    }
}
