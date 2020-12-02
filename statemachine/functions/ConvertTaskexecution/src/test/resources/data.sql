use sampledata;
INSERT IGNORE INTO `task_executions` (`uuid`, `tenant_uuid`, `root_quality_manual_uuid`, `root_process_ctrl_uuid`,
                               `timestamp_start`, `timestamp_start_zoneoffset`,
                               `shift_start`, `shift_start_zoneoffset`, `shift_end`,
                               `shift_end_zoneoffset`, `violation_level_aggregated`, `created`, `modified`)
VALUES (x'DEADBEEF000000000000000000000000', x'DEADBEEF100000000000000000000000', x'DEADBEEF200000000000000000000000',
        x'DEADBEEF300000000000000000000000', '2020-11-20 00:00:02', 3600, '2020-11-19 17:30:00',
        3600,
        '2020-11-20 03:00:00', 3600, 'none', '2020-11-20 00:00:06', '2020-11-20 00:00:06');
