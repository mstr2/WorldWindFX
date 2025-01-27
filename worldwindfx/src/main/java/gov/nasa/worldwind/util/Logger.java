/*
 * Copyright (c) 2016 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration. All Rights Reserved.
 */

package gov.nasa.worldwind.util;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Logger {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("org.worldwindFX");

    public static final int ERROR = 6;

    public static final int WARN = 5;

    public static final int INFO = 4;

    public static final int DEBUG = 3;

    protected static Map<String, String> messageTable;

    static {
        messageTable = new HashMap<>();
        messageTable.put("errorReadingProgramSource", "Error reading program sources");
        messageTable.put("exceptionParsingText", "Exception parsing text");
        messageTable.put("invalidBitmap", "The bitmap is recycled");
        messageTable.put("invalidCapacity", "The capacity is less than 1");
        messageTable.put("invalidClass", "The class is null or cannot be found");
        messageTable.put("invalidCount", "The count is invalid");
        messageTable.put("invalidClipDistance", "The clip distance is invalid");
        messageTable.put("invalidFieldOfView", "The field of view is invalid");
        messageTable.put("invalidHeight", "The height is invalid");
        messageTable.put("invalidIndex", "The index is invalid");
        messageTable.put("invalidNumIntervals", "The number of intervals is invalid");
        messageTable.put("invalidNumLevels", "The number of levels is invalid");
        messageTable.put("invalidRadius", "The radius is invalid");
        messageTable.put("invalidRange", "The range is invalid");
        messageTable.put("invalidResolution", "The resolution is invalid");
        messageTable.put("invalidResource", "The resource is invalid");
        messageTable.put("invalidStride", "The stride is invalid");
        messageTable.put("invalidTileDelta", "The tile delta is invalid");
        messageTable.put("invalidWidth", "The width is invalid");
        messageTable.put("invalidWidthOrHeight", "The width or the height is invalid");
        messageTable.put("missingArray", "The array is null or insufficient length");
        messageTable.put("missingBitmap", "The bitmap is null");
        messageTable.put("missingBuffer", "The buffer is null");
        messageTable.put("missingCache", "The cache is null");
        messageTable.put("missingCallback", "The callback is null");
        messageTable.put("missingCamera", "The camera is null");
        messageTable.put("missingColor", "The color is null");
        messageTable.put("missingConfig", "The configuration is null");
        messageTable.put("missingCoordinateSystem", "The coordinate system is null");
        messageTable.put("missingCoverage", "The coverage is null");
        messageTable.put("missingEllipsoid", "The ellipsoid is null");
        messageTable.put("missingFactory", "The factory is null");
        messageTable.put("missingFormat", "The format is null");
        messageTable.put("missingFrameMetrics", "The frame metrics argument is null");
        messageTable.put("missingGlobe", "The globe is null");
        messageTable.put("missingImageFormat", "The image format is null");
        messageTable.put("missingIterable", "The iterable is null");
        messageTable.put("missingKey", "The key is null");
        messageTable.put("missingLayer", "The layer is null");
        messageTable.put("missingLayerNames", "The layer names are null");
        messageTable.put("missingLevel", "The level is null");
        messageTable.put("missingLevelSet", "The level set is null");
        messageTable.put("missingLine", "The line is null");
        messageTable.put("missingList", "The list is null or empty");
        messageTable.put("missingListener", "The listener is null");
        messageTable.put("missingLocation", "The location is null");
        messageTable.put("missingLookAt", "The look-at is null");
        messageTable.put("missingMatrix", "The matrix is null");
        messageTable.put("missingModel", "The model is null");
        messageTable.put("missingName", "The name is null");
        messageTable.put("missingOffset", "The offset name is null");
        messageTable.put("missingPathName", "The path name is null");
        messageTable.put("missingPoint", "The point is null");
        messageTable.put("missingPlane", "The plane is null");
        messageTable.put("missingPosition", "The position is null");
        messageTable.put("missingProjection", "The projection is null");
        messageTable.put("missingRange", "The range is null");
        messageTable.put("missingRecognizer", "The recognizer is null");
        messageTable.put("missingRenderable", "The renderable is null");
        messageTable.put("missingResources", "The resources argument is null");
        messageTable.put("missingResult", "The result argument is null");
        messageTable.put("missingRunnable", "The runnable is null");
        messageTable.put("missingSector", "The sector is null");
        messageTable.put("missingServiceAddress", "The service address is null");
        messageTable.put("missingSource", "The source is null");
        messageTable.put("missingTile", "The tile is null");
        messageTable.put("missingTileFactory", "The tile factory is null");
        messageTable.put("missingTileMatrixSet", "The tile matrix set is null");
        messageTable.put("missingTileUrlFactory", "The tile url factory is null");
        messageTable.put("missingTypeface", "The typeface is null");
        messageTable.put("missingUrl", "The url is null");
        messageTable.put("missingViewport", "The viewport is null");
        messageTable.put("missingVector", "The vector is null");
        messageTable.put("missingVersion", "The version is null");
        messageTable.put("missingWorldWindow", "The WorldWindow is null");
        messageTable.put("singularMatrix", "The matrix cannot be inverted");
    }

    public static boolean isLoggable(int priority) {
        if (priority >= ERROR) {
            return LOGGER.isErrorEnabled();
        } else if (priority >= WARN) {
            return LOGGER.isWarnEnabled();
        } else if (priority >= INFO) {
            return LOGGER.isInfoEnabled();
        } else if (priority >= DEBUG) {
            return LOGGER.isDebugEnabled();
        }

        return false;
    }

    public static void log(int priority, String message) {
        if (priority >= ERROR) {
            LOGGER.error(message);
        } else if (priority >= WARN) {
            LOGGER.warn(message);
        } else if (priority >= INFO) {
            LOGGER.info(message);
        } else if (priority >= DEBUG) {
            LOGGER.debug(message);
        }
    }

    public static void log(int priority, String message, Throwable tr) {
        if (priority >= ERROR) {
            LOGGER.error(message, tr);
        } else if (priority >= WARN) {
            LOGGER.warn(message, tr);
        } else if (priority >= INFO) {
            LOGGER.info(message, tr);
        } else if (priority >= DEBUG) {
            LOGGER.debug(message, tr);
        }
    }

    public static String logMessage(int level, String className, String methodName, String message) {
        String msg = makeMessage(className, methodName, message);
        log(level, msg);

        return msg;
    }

    public static String logMessage(int level, String className, String methodName, String message, Throwable tr) {
        String msg = makeMessage(className, methodName, message);
        log(level, msg, tr);

        return msg;
    }

    public static String makeMessage(String className, String methodName, String message) {
        StringBuilder sb = new StringBuilder();
        String msg = messageTable.get(message);
        sb.append(className).append(".").append(methodName);
        sb.append(": ").append(msg != null ? msg : message);

        return sb.toString();
    }
}
