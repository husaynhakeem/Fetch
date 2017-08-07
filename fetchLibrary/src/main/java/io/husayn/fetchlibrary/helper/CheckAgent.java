package io.husayn.fetchlibrary.helper;

import java.net.URL;

import io.husayn.fetchlibrary.Fetch;
import io.husayn.fetchlibrary.ResourceType;
import io.husayn.fetchlibrary.image.ImageFetch;

/**
 * Created by husaynhakeem on 8/5/17.
 */

public class CheckAgent {


    private Fetch fetch;
    private boolean isFetchable = false;

    public CheckAgent(Fetch fetch) {
        this.fetch = fetch;
    }


    public void checkAttributes() {
        checkFetchInstance();
        checkContext();
        checkUrls();
        checkResourceType();
        checkItemsCount();

        if (fetch instanceof ImageFetch) {
            checkWidth();
            checkHeight();
        }

        isFetchable = true;
    }


    private void checkFetchInstance() {
        if (fetch == null)
            throw new RuntimeException("Fetch instance cannot be null");
    }


    private void checkContext() {
        if (fetch.getContext() == null)
            throw new RuntimeException("Fetch context attribute cannot be null");
    }


    private void checkUrls() {
        URL tempUrl;
        for (String url : fetch.getUrls()) {
            if (url == null)
                throw new RuntimeException("Fetch Url attribute cannot be null");
            if (url.trim().length() == 0)
                throw new RuntimeException("Fetch Url attribute  cannot be empty");
        }
    }


    private void checkResourceType() {
        if (fetch.getResourceType() == null)
            throw new RuntimeException("Fetch resource type attribute cannot be null");
        if (fetch.getResourceType() == ResourceType.NONE)
            throw new RuntimeException("Fetch resource type attribute cannot be set to NONE");
    }


    private void checkItemsCount() {
        if (fetch.getItemsCount() == 0)
            throw new RuntimeException("Fetch items count attribute cannot be set to 0 (Zero)");
        if (fetch.getItemsCount() < 0)
            throw new RuntimeException("Fetch items count attribute cannot be negative");
    }


    private void checkWidth() {
        ImageFetch imageFetch = (ImageFetch) fetch;
        if (imageFetch.getWidth() == 0)
            throw new RuntimeException("Image Fetch width attribute cannot be set to 0 (Zero)");
        if (imageFetch.getWidth() != ImageFetch.DEFAULT_DIMENSION && imageFetch.getWidth() < 0)
            throw new RuntimeException("Image Fetch width attribute cannot be negative");
    }


    private void checkHeight() {
        ImageFetch imageFetch = (ImageFetch) fetch;
        if (imageFetch.getHeight() == 0)
            throw new RuntimeException("Image Fetch height attribute cannot be set to 0 (Zero)");
        if (imageFetch.getHeight() != ImageFetch.DEFAULT_DIMENSION && imageFetch.getHeight() < 0)
            throw new RuntimeException("Image Fetch height attribute cannot be negative");
    }


    public boolean isFetchable() {
        return isFetchable;
    }
}
