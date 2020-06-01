package com.eltechs.axs.xserver.impl.drawables;

import android.util.Log;

import java.util.Collection;
import java.util.Collections;

public abstract class DrawablesFactoryImplBase implements DrawablesFactory {
    private final Visual preferredVisual;
    private final Collection<ImageFormat> supportedImageFormats;
    private final Collection<Visual> supportedVisuals;

    public DrawablesFactoryImplBase(Collection<Visual> collection, Collection<ImageFormat> collection2, Visual visual) {
        this.preferredVisual = visual;
        this.supportedVisuals = collection;
        this.supportedImageFormats = collection2;
    }

    public final Collection<Visual> getSupportedVisuals() {
        return Collections.unmodifiableCollection(this.supportedVisuals);
    }

    public final Collection<ImageFormat> getSupportedImageFormats() {
        return Collections.unmodifiableCollection(this.supportedImageFormats);
    }

    public final Visual getVisual(int i) {
        if (i == this.preferredVisual.getId()) {
            return this.preferredVisual;
        }
        for (Visual visual : this.supportedVisuals) {
            if (i == visual.getId() && visual.isDisplayable()) {
                return visual;
            }
        }
        return null;
    }

    public final Visual getPreferredVisual() {
        return this.preferredVisual;
    }

    @Override
    public final Visual getPreferredVisualForDepth(int i) {
        if (i == this.preferredVisual.getDepth()) {
            return this.preferredVisual;
        }

        for (Visual visual : this.supportedVisuals) {
            if (i == visual.getDepth()) {
                return visual;
            }
        }
        // TODO: FIXME it is always null.
        return null;
    }
}
