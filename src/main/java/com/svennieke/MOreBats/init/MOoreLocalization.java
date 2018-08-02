package com.svennieke.MOreBats.init;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Set;

import com.blamejared.ctgui.reference.Reference;

import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class MOoreLocalization implements IResourcePack {

	@Override
	public InputStream getInputStream(ResourceLocation location) throws IOException {
		if (location.getResourcePath().equals("lang/en_US.lang")) {
            return new ByteArrayInputStream("foo:bar".getBytes(StandardCharsets.UTF_8));
        } else {
            return null;
        }
	}

	@Override
	public boolean resourceExists(ResourceLocation location) {
        return location.getResourcePath().equals("lang/en_US.lang");
	}

	@Override
	public Set<String> getResourceDomains() {
        return Collections.singleton(Reference.MOD_ID);
	}

	@Override
	public <T extends IMetadataSection> T getPackMetadata(MetadataSerializer metadataSerializer,
			String metadataSectionName) throws IOException {
		return null;
	}

	@Override
	public BufferedImage getPackImage() throws IOException {
		return null;
	}

	@Override
	public String getPackName() {
		return "M'ore Resources";
	}

}
