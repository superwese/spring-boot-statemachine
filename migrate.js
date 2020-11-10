const fetch = require('node-fetch');
const moment = require('moment');
const config = require('./config');

const tenantUuids = ['5098df93-20c1-4a28-a007-cd548521d30a'];
const firstDayToMigrate = moment('2016-10-01', 'YYYY-MM-DD');
const lastDayToMigrate = moment('2020-11-11', 'YYYY-MM-DD');
const asStartOfDay = 'YYYY-MM-DD 00:00:00';
const asEndOfDay = 'YYYY-MM-DD 23:59:59';
const sdsPath = 'rest/admin/sample-data/api/migration/create-task-execution-imported-events/';

async function triggerMigration(tenantUuid, dayToMigrate) {

  const authorization = `Basic ${Buffer.from("Developer:" + process.env.PASSWORD).toString('base64')}`;
  const headers = {
    'Content-Type': 'application/json',
    'Authorization': authorization
  };

  const body = {
    tenantUuid: tenantUuid,
    timestampStart: dayToMigrate.format(asStartOfDay),
    timestampEnd: dayToMigrate.format(asEndOfDay)
  };

  const response = await fetch(
    `${config[process.env.STAGE][process.env.REGION].baseUrl}/${sdsPath}`,
    {
      method: 'POST',
      headers,
      body: JSON.stringify(body)
    }
  );

  if (response.status === 200) {
    return await response.json();
  } else {
    console.log(`Status code: ${response.status} triggerMigration`);
    throw new Error(`Status code: ${response.status} triggerMigration`);
  }
}

(async function() {

  for (const tenantUuid of tenantUuids) {
    let currentDate = firstDayToMigrate;

    do {
      console.log(`trigger migration for ${tenantUuid}, ${currentDate}`);

      await triggerMigration(tenantUuid, currentDate);

      currentDate.add(1, 'days');
    } while (!currentDate.isAfter(lastDayToMigrate))

  }

})().catch(console.error);
