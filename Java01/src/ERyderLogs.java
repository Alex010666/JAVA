import java.time.LocalDateTime;

    public class ERyderLogs {
        private String log;
        private String event;
        private LocalDateTime timeStamp;

        public ERyderLogs(String log, String event, LocalDateTime timeStamp) {
            this.log = log;
            this.event = event;
            this.timeStamp = timeStamp;
        }

        public String getLog() { return log; }
        public String getEvent() { return event; }
        public LocalDateTime getTimeStamp() { return timeStamp; }

        @Override
        public String toString() {
            return log + " - " + event + " - " + timeStamp;
        }
    }