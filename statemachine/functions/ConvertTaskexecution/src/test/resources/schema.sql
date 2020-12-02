CREATE SCHEMA IF NOT EXISTS sampledata;
use sampledata;
CREATE TABLE IF NOT EXISTS `task_executions` (
                                   `uuid` binary(16) NOT NULL,
                                   `tenant_uuid` binary(16) NOT NULL,
                                   `root_quality_manual_uuid` binary(16) NOT NULL,
                                   `root_process_ctrl_uuid` binary(16) NOT NULL,
                                   `timestamp_start` datetime NOT NULL,
                                   `timestamp_end` datetime,
                                   `timestamp_start_zoneoffset` int NOT NULL,
                                   `timestamp_end_zoneoffset` int,
                                   `shift_start` datetime DEFAULT NULL,
                                   `shift_start_zoneoffset` int DEFAULT NULL,
                                   `shift_end` datetime DEFAULT NULL,
                                   `shift_end_zoneoffset` int DEFAULT NULL,
                                   `violation_level_aggregated` varchar(64) NOT NULL,
                                   `created` datetime NOT NULL,
                                   `modified` datetime NOT NULL,
                                   PRIMARY KEY (`uuid`)

);
