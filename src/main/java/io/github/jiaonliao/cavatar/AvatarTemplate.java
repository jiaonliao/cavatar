package io.github.jiaonliao.cavatar;

import io.github.jiaonliao.cavatar.config.ColorConfig;
import io.github.jiaonliao.cavatar.constant.BaseWrapperShape;
import io.github.jiaonliao.cavatar.constant.Gender;
import io.github.jiaonliao.cavatar.constant.WidgetConstant;
import io.github.jiaonliao.cavatar.constant.WrapperShape;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wren
 */
public class AvatarTemplate {
    private final ColorConfig colorConfig;

    public AvatarTemplate(ColorConfig colorConfig) {
        this.colorConfig = colorConfig;
    }


    public String handleGenerate(AvatarOption avatarOption) {
        List<Widget<BaseWrapperShape>> widgets = avatarOption.getWidgets();
        widgets = widgets
                .stream()
                .sorted(Comparator.comparingInt(sh -> sh.getWidget().getLayer()))
                .collect(Collectors.toList());
        List<String> svgRaws = widgets
                .stream()
                .map((w) -> {
                    String asset = WidgetConstant.ASSET_MAPPING.get(w.getWidget());
                    if (asset != null && !"".equals(asset)) {
                        String svgRaw;
                        try (InputStream assetStream = w.getClass().getResourceAsStream(asset)) {
                            svgRaw = streamToString(assetStream);
                        } catch (IOException ioException) {
                            throw new RuntimeException(ioException);
                        }
                        String content = svgRaw
                                .substring(svgRaw.indexOf(">", svgRaw.indexOf("<svg")) + 1)
                                .replace("</svg>", "")
                                .replaceAll("\\$fillColor",
                                        w.getFillColor() != null && !"".equals(w.getFillColor()) ? w.getFillColor() : "'transparent'");
                        return "  <g>\n" + content + "</g>";
                    } else {
                        return "";
                    }
                }).collect(Collectors.toList());
        return "\n" +
                "    <svg\n" +
                "      style=\" background:" + avatarOption.getBackground() + " ;\"" +
                "      width=\"" + avatarOption.getSize() + "\"\n" +
                "      height=\"" + avatarOption.getSize() + "\"\n" +
                "      viewBox=\"0 0 " + avatarOption.getSize() / 0.7 + " " + avatarOption.getSize() / 0.7 + "\"\n" +
                "      preserveAspectRatio=\"xMidYMax meet\"\n" +
                "      fill=\"none\"\n" +
                "      xmlns=\"http://www.w3.org/2000/svg\"\n" +
                "    >\n" +
                "      <g transform=\"translate(100, 65)\">\n" + String.join("", svgRaws) +
                "      </g>\n" +
                "    </svg>\n" +
                "  ";
    }

    public String handleGenerate() {
        String hairColor = getRandomValue(colorConfig.getColors());
        AvatarOption option = new AvatarOption();
        option.setGender(getRandomValue(Gender.values()));
        option.setSize(280);
        option.setWrapperShape(WrapperShape.CIRCLE);
        option.setBackground(getRandomValue(colorConfig.getBackgroundColors(),
                new String[]{hairColor},
                null));
        option.setWidgets(Arrays.asList(new Widget<>(getRandomValue(WidgetConstant.Face.values())),
                new Widget<>(getRandomValue(WidgetConstant.Tops.values()), hairColor),
                new Widget<>(getRandomValue(WidgetConstant.Ear.values())),
                new Widget<>(getRandomValue(WidgetConstant.Earrings.values(),
                        null,
                        new WidgetConstant.Earrings[]{WidgetConstant.Earrings.NONE})),
                new Widget<>(getRandomValue(WidgetConstant.Eyebrows.values())),
                new Widget<>(getRandomValue(WidgetConstant.Eyes.values())),
                new Widget<>(getRandomValue(WidgetConstant.Nose.values())),
                new Widget<>(getRandomValue(WidgetConstant.Glasses.values())),
                new Widget<>(getRandomValue(WidgetConstant.Mouth.values())),
                new Widget<>(getRandomValue(WidgetConstant.Beard.values())),
                new Widget<>(getRandomValue(WidgetConstant.Clothes.values()), getRandomValue(colorConfig.getColors()))
        ));
        return handleGenerate(option);
    }

    private static <T> T getRandomValue(T[] values, T[] avoid, T[] usually) {
        if (values == null || values.length == 0) {
            return null;
        }
        Stream<T> valuesStream = Arrays.stream(values);
        if (!(avoid == null || avoid.length == 0)) {
            valuesStream = valuesStream.filter(v -> {
                for (T t : avoid) {
                    if (t == v) {
                        return false;
                    }
                }
                return true;
            });
        }
        List<T> targetValues = valuesStream.collect(Collectors.toList());
        if (usually != null) {
            for (T t : usually) {
                for (int i = 0; i < 15; i++) {
                    targetValues.add(t);
                }
            }
        }
        Random random = new Random();
        return targetValues.get(random.nextInt(targetValues.size()));
    }

    private static <T> T getRandomValue(T[] values) {
        return AvatarTemplate.getRandomValue(values, null, null);
    }

    private static String streamToString(InputStream input) throws IOException {
        if (input == null) {
            throw new RuntimeException("Missing avatar resources");
        }
        try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            for (int l; (l = input.read(buffer)) != -1; ) {
                result.write(buffer, 0, l);
            }
            return result.toString();
        }
    }


}
