# Generated by Django 2.1.5 on 2019-02-26 17:48

from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        ('sensors', '0004_auto_20190226_1842'),
    ]

    operations = [
        migrations.AlterField(
            model_name='sensorentry',
            name='created',
            field=models.DateTimeField(default=django.utils.timezone.now),
        ),
    ]
