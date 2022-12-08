
resource "aws_cloudwatch_metric_alarm" "alarmhandlekurv" {
  alarm_name                = "bank-sum-formetriks"
  namespace                 = "alarm-topic-${var.candidate_id}"
  metric_name               = "cart_count.value"

  comparison_operator       = "GreaterThanThreshold"
  threshold                 = "5"
  evaluation_periods        = "120"
  datapoints_to_alarm       = "3"
  period                    = "300"

  statistic                 = "Maximum"

  alarm_description         = "Alarm løses ut antall handlekurver over tre repeternde perioder,på fem minutter, overstiger verdien 5"
  insufficient_data_actions = []
  alarm_actions       = [aws_sns_topic.alarms.arn]
}

resource "aws_sns_topic" "alarms" {
  name = "alarm-topic-${var.candidate_id}"
}

resource "aws_sns_topic_subscription" "user_updates_sqs_target" {
  topic_arn = aws_sns_topic.alarms.arn
  protocol  = "email"
  endpoint  = var.candidate_email
}