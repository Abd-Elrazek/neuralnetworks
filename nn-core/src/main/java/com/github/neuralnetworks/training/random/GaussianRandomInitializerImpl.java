package com.github.neuralnetworks.training.random;

import java.util.Random;

import com.github.neuralnetworks.tensor.Tensor;

/**
 * Default implementation of the random initializer using JDK's default Random
 */
public class GaussianRandomInitializerImpl implements RandomInitializer
{

	private static final long serialVersionUID = 1L;

	protected Random random;
	protected float start;
	protected float end;
	protected Long seed = null;
	protected double std;

	public GaussianRandomInitializerImpl()
	{
		super();
		this.random = new Random();
		this.start = 0;
		this.end = 1;
		this.std = 1;
	}

	public GaussianRandomInitializerImpl(Random random)
	{
		super();
		this.random = random;
		this.start = 0;
		this.end = 1;
		this.std = 1;
	}

	public GaussianRandomInitializerImpl(float start, float end)
	{
		super();
		this.seed = new Random().nextLong();
		this.random = new Random(seed);
		this.start = start;
		this.end = end;
		this.std = 1;
	}

	public GaussianRandomInitializerImpl(float start, float end, long seed)
	{
		super();
		this.seed = seed;
		this.random = new Random(seed);
		this.start = start;
		this.end = end;
		this.std = 1;
	}

	/**
	 * if you use this constructor without a seed than it's not possible to reset the random initializer
	 * 
	 * @param random
	 * @param start
	 * @param end
	 */
	public GaussianRandomInitializerImpl(Random random, float start, float end)
	{
		super();
		this.random = random;
		this.start = start;
		this.end = end;
		this.std = 1;
	}

	public GaussianRandomInitializerImpl(Random random, long seed, float start, float end)
	{
		super();
		this.seed = seed;
		this.random = random;
		this.random.setSeed(seed);
		this.start = start;
		this.end = end;
		this.std = 1;
	}
	
	public GaussianRandomInitializerImpl(Random random, long seed, float start, float end, double std)
	{
		super();
		this.seed = seed;
		this.random = random;
		this.random.setSeed(seed);
		this.start = start;
		this.end = end;
		this.std = std;
	}

	@Override
	public void initialize(Tensor t)
	{
		float[] elements = t.getElements();
		t.forEach(i -> elements[i] = start + (float)(random.nextGaussian() * std));
	}

	public Random getRandom()
	{
		return random;
	}

	public void setRandom(Random random)
	{
		this.random = random;
	}

	public float getStart()
	{
		return start;
	}

	public void setStart(float start)
	{
		this.start = start;
	}

	public float getEnd()
	{
		return end;
	}

	public void setEnd(float end)
	{
		this.end = end;
	}


	@Override
	public boolean reset()
	{
		if (seed == null)
		{
			return false;
		}

		this.random.setSeed(this.seed);

		return true;
	}
}
