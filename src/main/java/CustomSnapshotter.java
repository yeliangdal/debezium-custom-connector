import io.debezium.connector.postgresql.PostgresConnectorConfig;
import io.debezium.connector.postgresql.snapshot.QueryingSnapshotter;
import io.debezium.connector.postgresql.spi.OffsetState;
import io.debezium.connector.postgresql.spi.SlotState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSnapshotter extends QueryingSnapshotter {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomSnapshotter.class);
    private OffsetState sourceInfo;

    @Override
    public void init(PostgresConnectorConfig config, OffsetState sourceInfo, SlotState slotState) {
        super.init(config, sourceInfo, slotState);
        this.sourceInfo = sourceInfo;
    }

    @Override
    public boolean shouldSnapshot() {
        return true;
    }

    @Override
    public boolean shouldStream() {
        return false;
    }

    @Override
    public boolean shouldStreamEventsStartingFromSnapshot() {
        return false;
    }
}
