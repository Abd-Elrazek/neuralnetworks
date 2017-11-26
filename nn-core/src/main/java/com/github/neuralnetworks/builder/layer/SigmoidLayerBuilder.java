package com.github.neuralnetworks.builder.layer;

import com.github.neuralnetworks.architecture.Layer;
import com.github.neuralnetworks.architecture.NeuralNetworkImpl;
import com.github.neuralnetworks.builder.layer.structure.NamedSingleInputLayerBuilder;
import com.github.neuralnetworks.training.Hyperparameters;

/**
 * @author tmey
 */
public class SigmoidLayerBuilder extends NamedSingleInputLayerBuilder
{

	public static String DEFAULT_LAYER_NAME = "SigmoidLayer";

	public SigmoidLayerBuilder()
	{
		super(DEFAULT_LAYER_NAME);
	}

	@Override
	protected Layer build(NeuralNetworkImpl neuralNetwork, String newLayerName, Layer inputLayer, Hyperparameters hyperparameters)
	{

		// TODO write content

		return null;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("SigmoidLayerBuilder{");
		sb.append("name=").append(getName());
		sb.append(", inputLayer=").append(getInputLayerName());
		sb.append('}');
		return sb.toString();
	}
}
