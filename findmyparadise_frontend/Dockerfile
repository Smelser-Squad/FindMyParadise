FROM node:lts-alpine AS development

RUN mkdir /frontend
WORKDIR /frontend
COPY . .

# RUN npm install -g @vue/cli
RUN npm ci
ENV HOST=0.0.0.0
CMD [ "npm", "run", "serve" ]

FROM development AS build
RUN npm run build

FROM nginx:1.13-alpine AS production

COPY --from=build /frontend/dist /usr/share/nginx/html
RUN rm -rf frontend