package com.example.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import static com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord;

/**
 * 「実践AWS Lambda」のP135に記載されているコード。<br/>
 * （９割ほど一緒だが、一部異なる点がある）
 * <p>
 * S3に配置されたリソースのContent-Type取得する処理。
 */
public class S3EventHandler {

    public String handler(S3Event event, Context context) {

        // ロガーの取得
        final LambdaLogger logger = context.getLogger();

        // S3のイベント通知オブジェクト?（ぶっちゃけよく分からん...）
        final S3EventNotificationRecord record = event.getRecords().get(0);

        // S3のバケット名とキーを取得
        final String bucket = record.getS3().getBucket().getName();
        final String key = record.getS3().getObject().getKey();

        // S3の情報を取得
        // 本では「new AmazonS3Client()」となっていたが、DeprecateされているのでBuilderに変更。
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        final S3Object s3Object = s3.getObject(new GetObjectRequest(bucket, key));

        // 関数の実行イベントとなったリソースのContent-Typeを取得する。
        final String contentType = s3Object.getObjectMetadata().getContentType();

        logger.log("Content Type : " + contentType);

        return contentType;
    }
}
