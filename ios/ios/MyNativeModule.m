#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(MyNativeModule, NSObject)

RCT_EXTERN_METHOD(callFragmentMethod:(NSString *)param)

@end
