package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;

import com.sun.imageio.plugins.bmp.BMPImageReader;
import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.jpeg.JPEGImageReader;
import com.sun.imageio.plugins.png.PNGImageReader;

public class ImgUtil
{
	/**
	 * 验证图片类型
	 * 
	 * @param file
	 * @return True|False
	 * @throws IOException
	 * @author lenovo
	 */
	public static boolean validateImgType(File file)
	{
		boolean flag = false;
		FileInputStream inFile = null;
		MemoryCacheImageInputStream imgCache = null;

		try
		{
			inFile = new FileInputStream(file);
			imgCache = new MemoryCacheImageInputStream(inFile);

			for (Iterator<?> it = ImageIO.getImageReaders(imgCache); it.hasNext();)
			{
				ImageReader reader = (ImageReader) it.next();
				if (reader instanceof GIFImageReader || reader instanceof JPEGImageReader || reader instanceof PNGImageReader || reader instanceof BMPImageReader)
				{
					flag = true;
				}
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				if (imgCache != null)
				{
					imgCache.close();
				}
			}
			catch (IOException e)
			{
				// TODO
				throw new RuntimeException(e);
			}
			finally
			{
				try
				{
					if (inFile != null)
					{
						inFile.close();
					}
				}
				catch (IOException e)
				{
					// TODO
					throw new RuntimeException(e);
				}
			}
		}

		return flag;
	}
}
