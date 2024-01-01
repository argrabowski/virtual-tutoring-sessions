package org.assistments.vts.manager;

import java.time.Instant;
import java.util.Optional;

import org.assistments.util.Pair;

public interface ZoomRequestHandler
{
  Pair<Pair<Long, String>, Optional<String>> getZoomURL(Instant expectedStartTime, int expectedDuration);

  Pair<String, Optional<String>> getZoomRecording(Long zoomId);
}